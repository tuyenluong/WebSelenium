# Hybrid Automation Framework

Core feature:

![Selenium - Java framework](https://github.com/user-attachments/assets/df39e156-4b26-4daa-9fed-f063335cd1a8)

- **Session Manager** manage entire testing runtime process, it manage the **Enhanced Driver** and **Global Config**
- **Enhanced Driver**:
	- **Enhanced Driver** has implemented the Web Driver interface, which will allow it to add more new characteristics related to the Web Driver (*Such as Data Mapper, Report*) and manage it within the context of the current driver.
	- **Data Mapper** 
		- Parse JSON file into a workable data object
		- Ability to parse a fixed structure of 2 objects, parent-child in the JSON file into an object of Map<Key, Value> pair.  Example: `DataManager.mapData("key")`
			- It enabled the ability to test in multiple environments or different contexts.
		- Implemented JsonPath parser, which enabled it to query the JSON file with a  more complex structure. Example: `DataManager.queryData($.firstObject.secondObject.thirdObject...)`
	- **Extent Report** (*TBC*)
- **Enhanced Element**
	- Implemented the Web Element interface
	- ![image](https://github.com/tuyenluong/WebSelenium/assets/76527250/033f7a42-d629-410c-9536-a0c55bf37f5e)
	- Provided lazy Init mechanism, only Init Web Element when the user calls one of the actions.
	- ![image](https://github.com/tuyenluong/WebSelenium/assets/76527250/b797b346-ce2f-41dc-83eb-b2d2012cca8a)
	- Handled most exceptions when interacting with the Web Element at Init. Example: `NoSuchElementException`, `StaleElementReferenceException`, `ElementNotInteractableException`, `TimeoutException`.
	- ![image](https://github.com/tuyenluong/WebSelenium/assets/76527250/a11a1608-b093-472e-9263-b024bbdde368)
 	
