package SGU.Kildeeva.SpringPractice;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;


public class Tests {
    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try {
            MetadataSources metadataSources = new MetadataSources(registry);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();


        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
    }
    @Test
    public void test()
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Bus> bus;
        bus = session.createQuery("from Bus ").list();
        for (Bus b: bus)
        {
            System.out.println(b.getId()+" "+b.getNumber()+" "+b.getCapacity());
            if (b.getBusStops()!= null)
            {
                System.out.println("BusStops");
                for (BusStop getBS: b.getBusStops())
                {
                    System.out.println(getBS);
                }
            }
        }

        session.getTransaction().commit();
        session.close();

    }


}
