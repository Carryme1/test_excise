import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

public class TestMock {


    public String methodA(){
        return "this is methodA";
    }


    public String methodB(String s){
        return "methodB" + s;
    }

    public  String methodB(Object o){
        return o.toString();
    }


    public Object methodC(Object o){
        throw new IllegalArgumentException("测试异常");
    }

    @Test
    public void TestA(){
        TestMock testMock = new TestMock();
        TestMock mock = Mockito.mock(TestMock.class);
//      自定义返回验证
        when(mock.methodA()).thenReturn("methodA");
        assertEquals(mock.methodA(), "methodA");
//      真实返回验证
        doCallRealMethod().when(mock).methodA();
        assertEquals(mock.methodA(), testMock.methodA());
//      自定义可输入的结果返回
        when(mock.methodB(anyString())).thenAnswer(Answers.CALLS_REAL_METHODS);
        assertEquals(mock.methodB(" hello"), "methodB hello");
//      自定义对象返回
        when(mock.methodB(any())).thenReturn(testMock.methodB(testMock));
        assertEquals(mock.methodB(new Object()), testMock.methodB(testMock));
//      自定义异常抛出
        when(mock.methodC(any())).thenThrow(new RuntimeException("mock"), new IllegalArgumentException("test"));



    }
}
