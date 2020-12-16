package org.peng.manager.test;

/**
 * @Author sp
 * @Description
 * @create 2020-12-03 15:23
 * @Modified By:
 */

public class User<T> {

  private T data;

  @Override
  public String toString() {
    return "User{" +
        "data=" + data +
        '}';
  }

  public User() {
  }

  public User(T data) {
    this.data = data;
  }

  public static <T> User<T> getInstances(T data) {
    return User.builders().data(data).build();
  }

  public static User.UserBuilder builders() {
    return new User.UserBuilder();
  }

  public static <T> User<T> getInstance(T data) {
    return  User.<T>builder().data(data).build();
  }


  public static <T> User.UserBuilder<T> builder() {
    return new User.UserBuilder<T>();
  }

  public static class UserBuilder<T> {

    T data;

    public UserBuilder(T data) {
      this.data = data;
    }

    public UserBuilder() {
    }


    public User.UserBuilder<T> data(T data) {
      this.data = data;
      return this;
    }

    public User<T> build() {
      return new User<T>(data);
    }

    @Override
    public String toString() {
      return "User{" +
          "data=" + data +
          '}';
    }
  }

}

