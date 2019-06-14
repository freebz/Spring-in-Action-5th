// Listing 12.2  Mapping the Order class to a Cassandra tacoorders table

@Data
@Table("tacoorders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id = UUIDs.timeBased();

    private Date placedAt = new Date();


    @Column("user")
    private UserUDT user;

    // delivery and credit card properties omitted for brevity's sake

    @Column("tacos")
    private List<TacoUDT> tacos = new ArrayList<>();

    public void addDesign(TacoUTD design) {
	this.tacos.add(design);
    }

}
