
package no.priv.garshol.duke.test;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertEquals;

import no.priv.garshol.duke.Record;
import no.priv.garshol.duke.RecordImpl;
import no.priv.garshol.duke.RecordIterator;
import no.priv.garshol.duke.datasources.InMemoryDataSource;

public class InMemoryDataSourceTest {

  @Test
  public void testEmpty() {
    InMemoryDataSource src = new InMemoryDataSource();
    RecordIterator it = src.getRecords();
    assertFalse("empty data source contains records",
                it.hasNext());
  }

  @Test
  public void testSimple() {
    Collection<Record> records = new ArrayList();
    records.add(TestUtils.makeRecord("ID", "1"));
    records.add(TestUtils.makeRecord("ID", "2"));
    records.add(TestUtils.makeRecord("ID", "3"));
    
    InMemoryDataSource src = new InMemoryDataSource(records);
    RecordIterator it = src.getRecords();

    assertTrue("record missing", it.hasNext());
    assertEquals("wrong record", it.next().getValue("ID"), "1");
    assertTrue("record missing", it.hasNext());
    assertEquals("wrong record", it.next().getValue("ID"), "2");
    assertTrue("record missing", it.hasNext());
    assertEquals("wrong record", it.next().getValue("ID"), "3");

    assertFalse("too many records",
                it.hasNext());
  }
}