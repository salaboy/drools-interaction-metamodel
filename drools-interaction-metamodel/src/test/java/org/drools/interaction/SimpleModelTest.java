/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.interaction;

import java.util.ArrayList;
import java.util.List;
import org.drools.runtime.rule.LiveQuery;
import org.drools.runtime.rule.Row;
import org.drools.runtime.rule.ViewChangedEventListener;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.interaction.domain.Exchange;
import org.drools.interaction.domain.items.Section;
import org.drools.interaction.domain.items.StringItem;
import org.drools.io.impl.ClassPathResource;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salaboy
 */
public class SimpleModelTest {

    public SimpleModelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        Exchange exchange = new Exchange();

        StringItem stringItem = new StringItem();
        Section sectionOne = new Section();

        sectionOne.addItem(stringItem.getId());
        exchange.addItem(sectionOne.getId());

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(new ClassPathResource("rules.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error : errors) {
                System.out.println("Error: " + error.getMessage());
            }
            throw new IllegalStateException("Knowledge cannot be parsed!");

        }

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        KnowledgeRuntimeLoggerFactory.newConsoleLogger(ksession);
//        ksession.addEventListener(new DebugWorkingMemoryEventListener());
//        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.insert(exchange);
        ksession.insert(sectionOne);
        ksession.insert(stringItem);

        ksession.fireAllRules();

//        
        final List updated = new ArrayList();

        final List removed = new ArrayList();

        final List added = new ArrayList();


        ViewChangedEventListener listener = new ViewChangedEventListener() {

            public void rowUpdated(Row row) {
                updated.add(row.get("$missingValue"));

            }

            public void rowRemoved(Row row) {
                removed.add(row.get("$missingValue"));

            }

            public void rowAdded(Row row) {
                added.add(row.get("$missingValue"));

            }
        };

        LiveQuery query = ksession.openLiveQuery("allMissingValuesByExchange",
                new Object[]{exchange.getId()},
                listener);

//        QueryResults results = ksession.getQueryResults("allMissingValuesByExchange", exchange.getId());
//
//
//        for (QueryResultsRow row : results) {
//            MissingValue missingValue = (MissingValue) row.get("$missingValue");
//            System.out.println("Missing Value for ItemID: " + missingValue.getItemId() + "\n");
//        }
        assertEquals(2, added.size());

    }
}
