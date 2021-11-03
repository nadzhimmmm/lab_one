import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.AssertionsKt;
import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    @org.junit.jupiter.api.Test
    void test_add_in_front() {
        List LIST1 = new List();
        LIST1.add_in_back(1);
        LIST1.add_in_back(2);
        LIST1.add_in_back(3);
        assertDoesNotThrow(() -> assertEquals(1, LIST1.front()));
    }

    @org.junit.jupiter.api.Test
    void test_add_in_back() {
        List LIST2 = new List();
        LIST2.add_in_back(1);
        LIST2.add_in_back(2);
        LIST2.add_in_back(3);
        assertDoesNotThrow(() -> assertEquals(3, LIST2.back()));
    }

    @org.junit.jupiter.api.Test
    void test_isEmpty() {
        List LIST3 = new List();
        assertTrue(LIST3.isEmpty());
        LIST3.add_in_front(4);
        assertFalse(LIST3.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void test_add_in_position() throws Exception {
        List LIST4=new List();
        LIST4.add_in_back(4);
        LIST4.add_in_back(5);
        assertDoesNotThrow(() -> LIST4.add_in_position(0,3));
        assertEquals(3, LIST4.get_element(0));
        assertEquals(3, LIST4.getSize());
        assertDoesNotThrow(() -> LIST4.add_in_position(0,5));
        assertEquals(5, LIST4.get_element(0));
        assertEquals(4, LIST4.getSize());
    }

    @org.junit.jupiter.api.Test
    void test_getSize() {
        List LIST5 = new List();
        LIST5.add_in_back(1);
        LIST5.add_in_back(2);
        LIST5.add_in_back(3);
        assertEquals(3, LIST5.getSize());
    }

    @org.junit.jupiter.api.Test
    void test_delete_back() {
        List LIST6=new List();
        LIST6.add_in_back(4);
        LIST6.add_in_back(5);
        LIST6.add_in_back(5);
        assertDoesNotThrow(() -> LIST6.delete_last());
        assertEquals(1, LIST6.getSize());
        assertDoesNotThrow(() -> LIST6.delete_last());
        assertEquals(0, LIST6.getSize());

    }

    @org.junit.jupiter.api.Test
    void test_delete_first() {
        List LIST7=new List();
        LIST7.add_in_back(4);
        LIST7.add_in_back(5);
        assertDoesNotThrow(() -> LIST7.delete_first());
        assertEquals(1, LIST7.getSize());
        assertDoesNotThrow(() -> LIST7.delete_first());
        assertEquals(0, LIST7.getSize());
    }

    @org.junit.jupiter.api.Test
    void test_delete_in_position() {
        List LIST8=new List();
        LIST8.add_in_back(4);
        LIST8.add_in_back(5);
        LIST8.add_in_back(6);
        LIST8.add_in_back(7);
        assertDoesNotThrow(() -> LIST8.delete_in_position(2));
        assertEquals(3, LIST8.getSize());
        assertDoesNotThrow(() -> LIST8.delete_in_position(2));
        assertEquals(2, LIST8.getSize());
    }
}