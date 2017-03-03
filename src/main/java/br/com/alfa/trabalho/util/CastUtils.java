package br.com.alfa.trabalho.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by pedro-dzs on 25/09/2015.
 */
public class CastUtils {

    public static final String PATTERN_DATE = "dd/MM/yyyy";
    public static final String PATTERN_DATETIME = "dd/MM/yyyy - HH:mm:ss";

    public static String byteArrayToString(Object byteArray) {
        if (byteArray == null) {
            return null;
        }
        return Arrays.toString((byte[]) byteArray).trim().replace(" ", "");
    }

    public static byte[] stringToByteArray(Object string) {
        if (string == null) {
            return null;
        }
        String value = (String) string;
        String[] byteValues = value.substring(1, value.length() - 1).split(",");
        byte[] bytes = new byte[byteValues.length];
        for (int i = 0, len = bytes.length; i < len; i++) {
            bytes[i] = Byte.parseByte(byteValues[i].trim());
        }
        return bytes;
    }

    public static String fileToStringTrim(File file) throws FileNotFoundException, IOException {
        return inputStreamToStringTrim(new FileInputStream(file));
    }

    public static String inputStreamToStringTrim(InputStream is) throws FileNotFoundException, IOException {
        InputStreamReader isf = new InputStreamReader(is, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(isf);
        String result = "";
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.replaceAll("\uFFFD", "");
            if (!line.trim().isEmpty()) {
                result = result + line.concat("\n");
            }
        }
        bufferedReader.close();
        isf.close();
        is.close();
        return result;
    }

    public static String objectToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static <T> T jsonToObject(String json, Class<T> classType) {
        Gson gson = new Gson();
        return gson.fromJson(json, classType);
    }

    public static Map<String, String> jsonToHashMap(String json) throws IOException {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    public static Date stringToDate(String date, String pattern) throws ParseException {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.parse(date);
    }

    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static byte[] concatByteArrays(byte[] array1, byte[] array2) {
        byte[] result = new byte[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }
}
