package com.bc.lottery.common.exception;

import com.bc.lottery.common.util.mapper.JsonMapper;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.Map;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    private Logger logger = LoggerFactory.getLogger(RestTemplateResponseErrorHandler.class);

    private JsonMapper jsonMapper = new JsonMapper();

    @Override
    public boolean hasError(ClientHttpResponse clienthttpresponse) throws IOException {
        if (clienthttpresponse.getStatusCode() != HttpStatus.OK) {
            logger.error("Status code: {}  Response: {} clienthttpresponse.getBody():{}", clienthttpresponse.getStatusCode(), clienthttpresponse.getStatusText(), clienthttpresponse.getBody());
            return true;
        }
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse clienthttpresponse) throws IOException {
        Map map = jsonMapper.fromJson(IOUtils.toString(clienthttpresponse.getBody(), "utf-8"), Map.class);
        String msg = MapUtils.getString(map, "msg");
        /*String msg = MapUtils.getString(map,"msg");
        if (clienthttpresponse.getStatusCode() == HttpStatus.FORBIDDEN) {
            throw new ServiceException(msg, ErrorCode.FORBIDDEN);
        }else if (clienthttpresponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new ServiceException(msg,ErrorCode.UNAUTHORIZED);
        }else if (clienthttpresponse.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            throw new ServiceException(msg,ErrorCode.UNAUTHORIZED);
        }else if (clienthttpresponse.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new ServiceException(msg,ErrorCode.NOT_FOUND);
        }else
            throw new ServiceException(msg,ErrorCode.FILE_STATUS_WRONG);*/
        throw new ServiceException( ErrorCode.STATUS_WRONG,msg);
    }
}
