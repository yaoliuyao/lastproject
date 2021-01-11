package bookshop.vo;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ResultVO {
    private int code;
    private Object data;
    private String message;

    private Map<String, Object> page = new HashMap<>();

    public Map<String, Object> getPage() {
        return page;
    }

    public ResultVO setPage(int pagenum, int pagesize, int totalpage) {
        this.page.put("pagenum",pagenum);
        this.page.put("pagesize",pagesize);
        this.page.put("totalpage",totalpage);
        return this;
    }

    private ResultVO() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResultVO success(Object data, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setData(data);
        resultVO.setMessage(message);
        return resultVO;
    }

    public static ResultVO err(int code, Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setData(data);
        return resultVO;
    }

    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
