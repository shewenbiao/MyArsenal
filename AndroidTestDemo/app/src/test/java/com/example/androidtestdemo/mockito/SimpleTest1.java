package com.example.androidtestdemo.mockito;

import com.example.androidtestdemo.mvp.MVPContract;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class SimpleTest1 {

    private ArrayList mMockList;

//    @Mock
//    private ArrayList mMockList;

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
        mMockList = mock(ArrayList.class);
    }

    @Test
    public void sampleTest1() throws Exception {
        mMockList.add("one");
        mMockList.clear();

        verify(mMockList).add("one");
        verify(mMockList).clear();
    }

    /**
     * mock接口对象
     *
     * @throws Exception
     */
    @Test
    public void sampleTest2() throws Exception {
        MVPContract.Presenter mockPresenter = mock(MVPContract.Presenter.class);
        when(mockPresenter.getUserName()).thenReturn("hello word");// 我们定义，当mockPresenter调用getUserName()时，返回hello word
        String userName = mockPresenter.getUserName();

        verify(mockPresenter).getUserName();//校验 是否mockPresenter调用了getUserName()方法
//        assertThat(userName, is("hello word"));
        Assert.assertEquals("hello word", userName);

//        verify(mockPresenter).getPassword();
        String pwd = mockPresenter.getPassword();
        verify(mockPresenter).getPassword();
//        Assert.assertNotNull(pwd);
        Assert.assertEquals("123", pwd);

    }

    /**
     * 参数匹配器
     *
     * @throws Exception
     */
    @Test
    public void argumentMatchersTest3() throws Exception {
        when(mMockList.get(anyInt())).thenReturn("hello word!\n");
        System.out.print(mMockList.get(0));
        System.out.print(mMockList.get(100));

        when(mMockList.addAll(argThat(getListMatcher()))).thenReturn(true);
        boolean b1 = mMockList.addAll(Arrays.asList("one", "two"));
        boolean b2 = mMockList.addAll(Arrays.asList("one", "two", "three"));

        verify(mMockList).addAll(argThat(getListMatcher()));
        Assert.assertTrue(b1);
        Assert.assertThat(b2, is(true));
    }

    private ListOfTwoElements getListMatcher() {
        return new ListOfTwoElements();
    }

    private class ListOfTwoElements implements ArgumentMatcher<List> {

        @Override
        public boolean matches(List argument) {
            return argument.size() == 2;
        }
    }

    /**
     * 我们也可以测试方法调用的次数
     * https://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#exact_verification
     *
     * @throws Exception
     */
    @Test
    public void simpleTest4() throws Exception {
        mMockList.add("once");
        mMockList.add("twice");
        mMockList.add("twice");
        mMockList.add("three times");
        mMockList.add("three times");
        mMockList.add("three times");
        verify(mMockList).add("once");//验证mockList.add("once")调用了一次 - times(1) is used by default
        verify(mMockList, times(1)).add("once");//验证mockList.add("once")调用了一次
        verify(mMockList, times(2)).add("twice");
        verify(mMockList, times(3)).add("three times");
        //从未调用校验
        verify(mMockList, never()).add("four times");
        //至少、至多调用校验
        verify(mMockList, atLeastOnce()).add("three times");
        verify(mMockList, atMost(5)).add("three times");
        verify(mMockList, atLeast(2)).add("five times"); //这行代码不会通过
    }

    /**
     * 异常抛出测试
     * https://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#stubbing_with_exceptions
     */
    @Test
    public void throwTest5() {
        doThrow(new NullPointerException("抛出空指针异常")).when(mMockList).clear();
        doThrow(new IllegalArgumentException("参数有问题")).when(mMockList).add(anyInt());
        mMockList.add("string");//这个不会抛出异常
        mMockList.add(2);//抛出了异常，因为参数是Int
        mMockList.clear();
    }

    /**
     * 验证执行执行顺序
     * https://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#in_order_verification
     *
     * @throws Exception
     */
    @Test
    public void orderTest6() throws Exception {
        List singleMock = mock(List.class);

        singleMock.add("first add");
        singleMock.add("second add");

        InOrder inOrder = inOrder(singleMock);
        //inOrder保证了方法的顺序执行
        inOrder.verify(singleMock).add("first add");
        inOrder.verify(singleMock).add("second add");

        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        firstMock.add("first add");
        secondMock.add("second add");


        InOrder inOrder1 = inOrder(firstMock, secondMock);

        //下列代码会确认是否firstmock优先secondMock执行add方法
        inOrder1.verify(firstMock).add("first add");
        inOrder1.verify(secondMock).add("second add");
    }

    /**
     * 确保mock对象从未进行过交互
     * https://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#never_verification
     *
     * @throws Exception
     */
    @Test
    public void noInteractedTest7() throws Exception {
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);
        List thirdMock = mock(List.class);

        firstMock.add("one");
        verify(firstMock).add("one");
        verify(firstMock, never()).add("two");

        firstMock.add(thirdMock);

        // 确保交互(interaction)操作不会执行在mock对象上
//        verifyZeroInteractions(firstMock); //test failed,因为firstMock和其他mock对象有交互
        verifyZeroInteractions(secondMock, thirdMock);   //test pass
    }

    /**
     * 方法连续调用的测试
     * https://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#stubbing_consecutive_calls
     */
    @Test
    public void continueMethodTest9() throws Exception {
        MVPContract.Presenter mockedUser = mock(MVPContract.Presenter.class);
        when(mockedUser.getUserName())
                .thenReturn("第一次调用")
                .thenThrow(new RuntimeException("方法调用第二次抛出异常"))
                .thenReturn("第三次调用");

        //另外一种方式
//        when(mockedUser.getUserName()).thenReturn("第一次调用", "方法调用第二次抛出异常", "第三次调用");

        String name1 = mockedUser.getUserName();

        try {
            String name2 = mockedUser.getUserName();
            System.out.println(name2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String name3 = mockedUser.getUserName();

        System.out.println(name1);
        System.out.println(name3);
    }

    /**
     * 拦截方法返回值（常用）
     * doReturn()、doThrow()、doAnswer()、doNothing()、doCallRealMethod()系列方法的运用
     * https://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#do_family_methods_stubs
     */
    @Test
    public void returnTest() throws Exception {
        //返回值为null的函数，可以通过这种方式进行测试
        doAnswer(invocation -> {
            System.out.println("测试无返回值的函数");
            return null;
        }).when(mMockList).clear();

        doThrow(new RuntimeException("测试无返回值的函数->抛出异常"))
                .when(mMockList).add(eq(1), anyString());

        doNothing().when(mMockList).add(eq(2), anyString());
//        doReturn("123456").when(mMockList).add(eq(3), anyString()); //不能把空返回值的函数与doReturn关联

        mMockList.clear();
        mMockList.add(2, "123");
        mMockList.add(3, "123");
        mMockList.add(4, "123");
        mMockList.add(5, "123");

        //但是请记住这些add实际上什么都没有做，mock对象中仍然什么都没有
        System.out.print(mMockList.get(4));
    }

    /**
     * 监控真实对象
     * https://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#spy
     */
    @Test
    public void spyTest() throws Exception {
        List list = new ArrayList();
        List spyList = spy(list);

        //当spyList调用size()方法时，return100
        when(spyList.size()).thenReturn(100);

        spyList.add("one");
        spyList.add("two");

        System.out.println("spyList第一个元素" + spyList.get(0));
        System.out.println("spyList.size = " + spyList.size());

        verify(spyList).add("one");
        verify(spyList).add("two");

        //请注意！下面这行代码会报错！ java.lang.IndexOutOfBoundsException: Index: 10, Size: 2
//        when(spyList.get(10)).thenReturn("ten");

        doReturn("ten").when(spyList).get(10);

        System.out.println("spyList第10个元素" + spyList.get(10));

        //Mockito并不会为真实对象代理函数调用，实际上它会拷贝真实对象。因此如果你保留了真实对象并且与之交互
        // 不要期望从监控对象得到正确的结果。当你在监控对象上调用一个没有被stub的函数时并不会调用真实对象的对应函数，你不会在真实对象上看到任何效果。
        // 因此结论就是 : 当你在监控一个真实对象时，你想在stub这个真实对象的函数，那么就是在自找麻烦。或者你根本不应该验证这些函数
    }

    /**
     * 捕获参数（重要）
     * 为接下来的断言捕获参数(API1.8+)
     * https://static.javadoc.io/org.mockito/mockito-core/2.8.9/org/mockito/Mockito.html#captors
     */
    @Test
    public void captorTest() throws Exception {
        Student student = new Student();
        student.setName("hello world");

        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);
        mMockList.add(student);
        verify(mMockList).add(captor.capture());

        Student value = captor.getValue();

        Assert.assertEquals(value.getName(),"hello world");

        //我们将定义好的ArgumentCaptor参数捕获器放到我们需要去监控捕获的地方，如果真的执行了该方法，
        // 我们就能通过captor.getValue()中取到参数对象，如果没有执行该方法，那么取到的只能是null或者基本类型的默认值
    }

    private class Student {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
