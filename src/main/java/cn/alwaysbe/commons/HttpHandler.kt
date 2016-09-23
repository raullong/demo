package cn.alwaysbe.commons

import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClients
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils
import org.springframework.stereotype.Service

/**
 * Created by raul on 2016/9/23.
 *
 * 佛祖保佑，永无BUG！
 */
@Service
class HttpHandler {


    fun doPost() {
        val httpClient = HttpClients.createDefault()
        val url = ""
        val httpPost = HttpPost(url)

        // 参数
        val params = mutableListOf<NameValuePair>()
        params.add(BasicNameValuePair("type", "house"))

        try {
            val entity = UrlEncodedFormEntity(params, "UTF-8")
            httpPost.entity = entity

            val response = httpClient.execute(httpPost)
            try {
                val respEntity = response.entity
                if (respEntity != null) {
                    EntityUtils.toString(entity, "UTF-8")
                }
            } finally {
                response.close()
            }
        } catch (e: Exception) {

        } finally {
            httpClient.close()
        }
    }
}