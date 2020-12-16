package org.peng.manager;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author sp
 * @Description
 * @create 2020-11-30 18:11
 * @Modified By:
 */
public class MianTest {


  public static void main(String[] args) {

//    Pattern humpPattern = Pattern.compile("[A-Z]");
//    String str = "createTimeEnd";
//    Matcher matcher = humpPattern.matcher(str);
//    StringBuffer sb = new StringBuffer();
//
//    while (matcher.find()) {
//
//      System.out.println(matcher.group(0));
//      matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
//      System.out.println(sb);
//    }
//    matcher.appendTail(sb);
//    System.out.println(str);
//    String s = sb.toString();
//    System.out.println(s);
//    System.out.println(matcher.replaceAll("1111"));
    String sort = "   order by name desc   ";
    System.out.println("***"+sort.trim()+"***");
    String[] sorts = sort.trim().split("\\s+");
//    for (String str :sorts){
//
//      System.out.println(str);
//    }
    System.out.println(StringUtils.isAlphanumeric("1"));
  }


}


