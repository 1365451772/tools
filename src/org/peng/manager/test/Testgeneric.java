package org.peng.manager.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author sp
 * @Description
 * @create 2020-12-03 14:08
 * @Modified By:
 */

public class Testgeneric <T>{

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  T data;

  public Testgeneric() {
  }

  public Testgeneric(T data) {
    this.data = data;
  }

  public static  <R> Testgeneric<R> get(R date){
    return new Testgeneric<R>(date);
  }


  public static  <R> Testgeneric<R> get1(R date){
    return new Testgeneric<>(date);
  }

  public static  <R>  R get3(R date){
    return date;
  }

  public static <R,V> Map<R,V> getMap(R key,V value){
    HashMap<R, V> map = new HashMap<>();
    map.put(key,value);
    return map;
  }
  public static <T> Testgeneric<T> get(){
    return new Testgeneric<T>();
  }



}
