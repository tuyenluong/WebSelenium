package com.web.selenium.webSelenium.data;

import com.web.selenium.webSelenium.utils.fileTypes.JsonParser;

public class DataMapper {

    private String path;
    private String language;
    private TestData testData;

    public DataMapper(String path, String language){
        this.path = path;
        this.language = language;
        readFile();
    }

    private void readFile() {
        testData = new JsonParser<TestData>().parse(path,TestData.class);
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
}
