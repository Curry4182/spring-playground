package com.gorani.springplayground.java.generic.wildcard;

import java.util.Collection;
import java.util.function.Consumer;

public class MyParentProcessor {

    public static void consumeMyParentsByUpperBound(Collection<? extends MyParent> myParents, Consumer<Object> consumer) {

        /* 컴파일 오류
          for(MyChild e : myParents) {
              System.out.println(e);
          }

        */

        for(MyParent e : myParents) {
            consumer.accept(e);
        }

        for(MyGrandParent e : myParents) {
            consumer.accept(e);
        }

        for(Object e : myParents) {
            consumer.accept(e);
        }
    }

    public static void addMyParentsByUpperBound(Collection<? extends MyParent> originMyParents) {

        /*
        컴파일 오류

        MyChild newMyChild = new MyChild();
        originMyParents.add(newMyChild);

        MyParent newMyParent = new MyParent();
        originMyParents.add(newMyParent);

        MyGrandParent newMyGrandParent = new MyGrandParent();
        originMyParents.add(newMyGrandParent);

        Object newObject = new Object();
        originMyParents.add(newObject);
        */

        // null 추가 가능
        originMyParents.add(null);
    }

    public static void consumeMyParentsByLowerBound(Collection<? super MyParent> myParents, Consumer<Object> consumer) {

        /*
        컴파일 오류
        for(MyChild e : myParents) {
          System.out.println(e);
        }

        for(MyParent e : myParents) {
            consumer.accept(e);
        }

        for(MyGrandParent e : myParents) {
            consumer.accept(e);
        }
        */

        for(Object e : myParents) {
            consumer.accept(e);
        }
    }


    public static void addMyParentsByLowerBound(Collection<? super MyParent> originMyParents) {

        MyChild newMyChild = new MyChild();
        originMyParents.add(newMyChild);

        MyParent newMyParent = new MyParent();
        originMyParents.add(newMyParent);

        /*
        컴파일 오류
        MyGrandParent newMyGrandParent = new MyGrandParent();
        originMyParents.add(newMyGrandParent);

        Object newObject = new Object();
        originMyParents.add(newObject);
        */

        // null 추가 가능
        originMyParents.add(null);
    }

    public static void consumeMyParentsByUnBound(Collection<?> myParents, Consumer<Object> consumer) {

        /*
        컴파일 오류
        for(MyChild e : myParents) {
          System.out.println(e);
        }

        for(MyParent e : myParents) {
            consumer.accept(e);
        }

        for(MyGrandParent e : myParents) {
            consumer.accept(e);
        }
        */

        for(Object e : myParents) {
            consumer.accept(e);
        }
    }


    public static void addMyParentsByUnBound(Collection<?> originMyParents) {

        /*
        컴파일 오류
        MyChild newMyChild = new MyChild();
        originMyParents.add(newMyChild);

        MyParent newMyParent = new MyParent();
        originMyParents.add(newMyParent);

        MyGrandParent newMyGrandParent = new MyGrandParent();
        originMyParents.add(newMyGrandParent);

        Object newObject = new Object();
        originMyParents.add(newObject);
        */

        // null 추가 가능
        originMyParents.add(null);
    }

    public static void consumeMyParentsByObject(Collection<Object> myParents, Consumer<Object> consumer) {

        /*
        컴파일 오류
        for(MyChild e : myParents) {
          System.out.println(e);
        }

        for(MyParent e : myParents) {
            consumer.accept(e);
        }

        for(MyGrandParent e : myParents) {
            consumer.accept(e);
        }
        */

        for(Object e : myParents) {
            consumer.accept(e);
        }
    }


    public static void addMyParentsByObject(Collection<Object> originMyParents) {

        MyChild newMyChild = new MyChild();
        originMyParents.add(newMyChild);

        MyParent newMyParent = new MyParent();
        originMyParents.add(newMyParent);

        MyGrandParent newMyGrandParent = new MyGrandParent();
        originMyParents.add(newMyGrandParent);

        Object newObject = new Object();
        originMyParents.add(newObject);

        originMyParents.add(null);
    }
}
