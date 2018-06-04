package conference;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ConferenceTest {
    private ConferenceSearch search;

    @Before
    public void setUp() throws Exception {
        search = new ConferenceSearch();
    }

    @Test
    public void testSearchConferenRooms() {
        List<Room> rooms = search.search("杭州");
        Assert.assertEquals("001", rooms.get(0).getRoomId());
        rooms = search.search("上海");
        Assert.assertEquals("002", rooms.get(0).getRoomId());
        rooms = search.search("北京");
        Assert.assertEquals("003", rooms.get(0).getRoomId());
    }

    @Test
    public void testSearchConferenRoomsAddrIsNull() {
        //地址为空返回所有酒店
        List<Room> rooms = search.search(null);
        Assert.assertTrue(rooms.size() > 0);
    }

    @Test
    public void testsearchAndSortByPriceRooms() {
        List<Room> rooms = search.searchAndSortByPrice("杭州", "free");
        System.out.println(rooms);
        Assert.assertTrue(rooms.size() > 0);
        Assert.assertEquals("杭州", rooms.get(0).getAddr());
        Assert.assertEquals("free", rooms.get(0).getStatus());
    }

    @Test
    public void testReserveRoom(){
        ConferenceReserve reserve = new ConferenceReserve();
        List<Room> rooms = search.searchAndSortByPrice("杭州", "free");
        Assert.assertTrue(rooms.size() > 0);
        Assert.assertEquals("杭州", rooms.get(0).getAddr());
        Assert.assertEquals("free", rooms.get(0).getStatus());
        Assert.assertTrue(reserve.reserve(rooms.get(0).getRoomId()));

    }
}
