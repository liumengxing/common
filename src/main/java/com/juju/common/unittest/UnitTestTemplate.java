package com.juju.common.unittest;

import com.juju.common.entity.JujuRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.StringUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * 单元测试
 *
 * @param <T>
 */
public abstract class UnitTestTemplate<T extends JujuRequest> {
    HttpHeaders headers = new HttpHeaders();
    public T request;
    public String url;
    public ResultActions resultActions;

    protected abstract void prepareData() throws Exception;

    protected abstract void executeTest() throws Exception;

    protected abstract void assertResult() throws Exception;

    public void run() throws Exception {
        // 准备数据
        try {
            headers.set("ip", "255.255.0.1");
            this.prepareData();
        } catch (Exception ex) {
            throw ex;
        }

        // 执行测试
        try {
            this.executeTest();
        } catch (Exception ex) {
            throw ex;
        }

        // 断言结果
        try {
            this.assertResult();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void doGet(MockMvc mvc) throws Exception {
        //检查
        if (mvc == null) {
            throw new Exception();
        }
        if (StringUtils.isEmpty(url)) {
            throw new Exception();
        }

        try {
            resultActions = mvc.perform(get(url).headers(headers).param("username", "juju"));
        } catch (Exception e) {
            throw e;
        }
    }

}
