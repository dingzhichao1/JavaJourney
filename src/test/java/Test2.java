import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Auther: DingZhichao
 * @Date: 2021/3/5 21:20
 * @Description:
 */
public class Test2 {
    private final static Charset UTF8 = StandardCharsets.UTF_8;
    private final static String SECRET_ID = "AKIDHK95rzWlJhMeiasixXw84lERNZZKxEON";
    private final static String SECRET_KEY = "8VgdJl281icIi5KM7cuQinieLn8FJ8i3";

    public static void main(String[] args) throws Exception {
        long dateTime = System.currentTimeMillis()/1000L;

        String timestamp = String.valueOf(dateTime);
        //String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 注意时区，否则容易出错
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = sdf.format(new Date(Long.valueOf(timestamp + "000")));
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"Action\": \"CreateRecTask\",\r\n    \"Version\": \"2019-06-14\",\r\n    \"EngineModelType\": \"16k_zh\",\r\n    \"ChannelNum\": 1,\r\n    \"ResTextFormat\": 0,\r\n    \"SourceType\": 1,\r\n    \"Data\": \"ssss\"\r\n}");
        Request request = new Request.Builder()
                .url("https://asr.tencentcloudapi.com")
                .method("POST", body)
                .addHeader("X-TC-Action", "CreateRecTask")
                .addHeader("X-TC-Timestamp", timestamp)
                .addHeader("X-TC-Version", "2019-06-14")
                .addHeader("Authorization", getAt(date,timestamp))
                                .addHeader("Content-Type", "application/json; charset=utf-8")
                                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
    public static String getAt(String date,String timestamp) throws Exception {
        String service = "asr";
        String host = "asr.tencentcloudapi.com";
        String region = "ap-guangzhou";
        String action = "CreateRecTask";
        String version = "2019-06-14";
        String algorithm = "TC3-HMAC-SHA256";


        // ************* 步骤 1：拼接规范请求串 *************
        String httpRequestMethod = "POST";
        String canonicalUri = "/";
        String canonicalQueryString = "";
        String canonicalHeaders = "content-type:application/json; charset=utf-8\n" + "host:" + host + "\n";
        String signedHeaders = "content-type;host";

        String payload = "{\"Limit\": 1, \"Filters\": [{\"Values\": [\"\\u672a\\u547d\\u540d\"], \"Name\": \"instance-name\"}]}";
        String hashedRequestPayload = sha256Hex(payload);
        String canonicalRequest = httpRequestMethod + "\n" + canonicalUri + "\n" + canonicalQueryString + "\n"
                + canonicalHeaders + "\n" + signedHeaders + "\n" + hashedRequestPayload;
        System.out.println(canonicalRequest);

        // ************* 步骤 2：拼接待签名字符串 *************
        String credentialScope = date + "/" + service + "/" + "tc3_request";
        String hashedCanonicalRequest = sha256Hex(canonicalRequest);
        String stringToSign = algorithm + "\n" + timestamp + "\n" + credentialScope + "\n" + hashedCanonicalRequest;
        System.out.println(stringToSign);

        // ************* 步骤 3：计算签名 *************
        byte[] secretDate = hmac256(("TC3" + SECRET_KEY).getBytes(UTF8), date);
        byte[] secretService = hmac256(secretDate, service);
        byte[] secretSigning = hmac256(secretService, "tc3_request");
        String signature = DatatypeConverter.printHexBinary(hmac256(secretSigning, stringToSign)).toLowerCase();
        System.out.println(signature);

        // ************* 步骤 4：拼接 Authorization *************
        String authorization = algorithm + " " + "Credential=" + SECRET_ID + "/" + credentialScope + ", "
                + "SignedHeaders=" + signedHeaders + ", " + "Signature=" + signature;
        System.out.println(authorization);
        return authorization;
    }

    public static byte[] hmac256(byte[] key, String msg) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, mac.getAlgorithm());
        mac.init(secretKeySpec);
        return mac.doFinal(msg.getBytes(UTF8));
    }

    public static String sha256Hex(String s) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] d = md.digest(s.getBytes(UTF8));
        return DatatypeConverter.printHexBinary(d).toLowerCase();
    }
}
