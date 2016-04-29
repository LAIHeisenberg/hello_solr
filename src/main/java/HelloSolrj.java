import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;
import pojo.Item;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Heisenberg on 4/28/16.
 */
public class HelloSolrj {

    public static void main(String[] args){

        String zkHostString = "localhost:9983";
        SolrClient solr = new CloudSolrClient(zkHostString);

        try {

            SolrQuery query2 = new SolrQuery();
            query2.setQuery("Glen Cook");

            QueryResponse resp = solr.query("books",query2);
            SolrDocumentList results1 = resp.getResults();
            System.out.println(results1.toString());
            SolrInputDocument doc = new SolrInputDocument();
/*
            Item item1 = new Item("1","book","20");
            Item item2 = new Item("2","book","40");
            Item item3 = new Item("3","food","14");
            Item item4 = new Item("5","cloth","70");

            List<Item> items = Arrays.asList(item1,item2,item3,item4);

            solr.addBeans("books",items);
            solr.commit("books");*/

            SolrDocument docById = solr.getById("books","1");
            Object cat = docById.get("cat");
            System.out.println(cat.toString());



            SolrQuery query3 = new SolrQuery();
            query3.setQuery("cat:food");
            resp = solr.query("books",query3);
            results1 = resp.getResults();
            System.out.println(results1.toString());


            List<Item> beans = resp.getBeans(Item.class);
            Item item = beans.get(0);
            System.out.println(item.getPrice().get(0));

            UpdateRequest update = new UpdateRequest();

        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
