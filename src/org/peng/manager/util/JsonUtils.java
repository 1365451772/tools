package org.peng.manager.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * @Author
 * @Description
 * @create 2020-11-30 18:24
 * @Modified By:
 */
public class JsonUtils {

    private static ObjectMapper defaultMapper = new ObjectMapper();

    static {
        //序列化的时候序列对象的所有属性
        defaultMapper.setSerializationInclusion(Include.ALWAYS);
        //反序列化的时候如果多了其他属性,不抛出异常
        defaultMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //如果是空对象的时候,不抛异常
        defaultMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
        defaultMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        defaultMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        defaultMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
    }

    /**
     * 将对象转化为json数据
     *
     * @param obj the obj
     * @return string string
     * @throws IOException the io exception
     */
    public static String toJson(Object obj) {
        Preconditions.checkArgument(obj != null, "this argument is required; it must not be null");
        String json = null;
        try {
            json = defaultMapper.writeValueAsString(obj);
        } catch (IOException e) {

        }
        return json;
    }

    /**
     * 将对象转化为json数据
     *
     * @param obj    the obj
     * @param pretty pretty to json
     * @return string string
     * @throws IOException the io exception
     */
    public static String toJson(Object obj, boolean pretty) {
        Preconditions.checkArgument(obj != null, "this argument is required; it must not be null");
        String json = null;
        try {
            if (pretty) {
                json = defaultMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            } else {
                json = defaultMapper.writeValueAsString(obj);
            }
        } catch (IOException e) {

        }
        return json;
    }

    /**
     * json数据转化为对象(Class) User u = com.firmware.common.JacksonUtil.parseJson(jsonValue, User.class);
     * User[] arr = com.firmware.common.JacksonUtil.parseJson(jsonValue, User[].class);
     *
     * @param <T>       the type parameter
     * @param jsonValue the json value
     * @param valueType the value type
     * @return t t
     * @throws IOException the io exception
     */
    public static <T> T parseJson(String jsonValue, Class<T> valueType) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue),
                "this argument is required; it must not be null");
        try {
            return defaultMapper.readValue(jsonValue, valueType);
        } catch (IOException e) {

        }
        return null;
    }

    /**
     * json数据转化为Map<String,Object>
     *
     * @param <T>           the type parameter
     * @param jsonValue     the json value
     * @param typeReference the value type
     * @return t t
     * @throws IOException the io exception
     */
    public static <T> T parseJson(String jsonValue, TypeReference typeReference) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue),
                "this argument is required; it must not be null");
        try {
            return defaultMapper.readValue(jsonValue, typeReference);
        } catch (IOException e) {

        }
        return null;
    }

    /**
     * json 对象转化为JsonNode
     *
     * @param jsonObject the json value
     * @return JsonNode
     * @throws IOException the io exception
     */
    public static <T> T parseJson(Object jsonObject, Class<T> valueType) {
        Preconditions.checkArgument(!Objects.isNull(jsonObject),
                "this argument is required; it must not be null");
        return defaultMapper.convertValue(jsonObject, valueType);
    }


    /**
     * 判断是否是合法Json
     *
     * @param jsonInString
     * @return
     */
    public final static boolean isJSONValid(String jsonInString) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonInString);
            return true;
        } catch (IOException e) {
            return false;
        }
    }


}
