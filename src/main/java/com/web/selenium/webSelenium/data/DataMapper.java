package com.web.selenium.webSelenium.data;


import com.jayway.jsonpath.DocumentContext;
import com.web.selenium.webSelenium.utils.JsonParser;

public class DataMapper {

    private String path;
    private String language;
    private TestData testData;
    private DocumentContext document;

    public DataMapper(String path, String language){
        this.path = path;
        this.language = language;
        testData  = new JsonParser<TestData>().parse(this.path,TestData.class);
        document = new JsonParser<DocumentContext>().jsonPathParser(this.path);
    }
	
    private DataByLanguage getDataLanguages(){
        return testData.get(language);
    }

    public String mapValue(String inputValue) {
        return getDataLanguages().get(inputValue);
    }

    public void updateValue(String key, String inputValue) {
        getDataLanguages().replace(key,inputValue);
    }

    public void setValue(String key, String inputValue) {
        getDataLanguages().put(key,inputValue);
    }

	public String queryData(String query) {
		Object result = null;
		try {
			result = document.read(query);
			return result.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}
}
