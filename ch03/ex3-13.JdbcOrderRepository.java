// Listing 3.13  Creating a SimpleJdbcInsert from a JdbcTemplate

package tacos.data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.uitl.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import tacos.Taco;
import tacos.Order;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderTacoInserter;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {
	this.orderInserter = new SimpleJdbcInsert(jdbc)
	    .withTableName("Taco_Order")
	    .usingGeneratedKeyColumns("id");

	this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
	    .withTableName("Taco_Order_Tacos");

	this.objectMapper = new ObjectMapper();
    }

...

}
