package unitTesting.client.api;

import unitTesting.client.ApiClient;
import unitTesting.client.ApiException;
import unitTesting.client.ApiResponse;
import unitTesting.client.Configuration;
import unitTesting.client.Pair;
import unitTesting.client.ProgressRequestBody;
import unitTesting.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityApi {
    private ApiClient apiClient;

    public SecurityApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SecurityApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    
    public okhttp3.Call securityTestCall(String xApiKey, String body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        String localVarPath = "";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/text"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/text"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    private okhttp3.Call securityTestValidateBeforeCall(String xApiKey, String body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling securityTest(Async)");
        }
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling securityTest(Async)");
        }
        

        okhttp3.Call call = securityTestCall(xApiKey, body, progressListener, progressRequestListener);
        return call;

    }
    
    public String securityTest(String xApiKey, String body) throws ApiException {
        ApiResponse<String> resp = securityTestWithHttpInfo(xApiKey, body);
        return resp.getData();
    }
    
    public ApiResponse<?>  securityGenericTest(String xApiKey, String body) throws ApiException {
    	ApiResponse<?> resp = securityTestWithHttpInfo(xApiKey, body);
        return resp;
    }

    public ApiResponse<String> securityTestWithHttpInfo(String xApiKey, String body) throws ApiException {
        okhttp3.Call call = securityTestValidateBeforeCall(xApiKey, body, null, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

}
