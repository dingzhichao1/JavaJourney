import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.asr.v20190614.AsrClient;
import com.tencentcloudapi.asr.v20190614.models.*;;

public class CreateRecTask
{
    public static void main(String [] args) {
        try{

            Credential cred = new Credential("AKIDHK95rzWlJhMeiasixXw84lERNZZKxEON", "8VgdJl281icIi5KM7cuQinieLn8FJ8i3");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("asr.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            AsrClient client = new AsrClient(cred, "", clientProfile);

            CreateRecTaskRequest req = new CreateRecTaskRequest();
            req.setEngineModelType("16k_zh");
            req.setChannelNum(1L);
            req.setResTextFormat(0L);
            req.setSourceType(1L);
            req.setData("ssss");

            CreateRecTaskResponse resp = client.CreateRecTask(req);

            System.out.println(CreateRecTaskResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }

    }

}