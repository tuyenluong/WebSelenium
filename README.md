# Hybrid Automation Frameworks

Core features:
- **Session Manager** manage entire testing runtime process, it manage the **Enhanced Driver** and **Global Config**
- **Enhanced Driver**:
	- **Enhanced Driver** has a implemented the Web Driver interface, which will allow it to add more new characteristics related to the Web Driver (*Such as Data Mapper, Report*) and manage it within the context of the current driver.
	- **Data Mapper** 
		- Parse JSON file into a workable data object
		- Ability to parse a fix structure of a 2 objects, parent-child in the JSON file into a object of Map<Key, Value> pair.  Example: `DataManager.mapData("key")`
			- It enabled ability to test in multiple environment or different context.
		- Implemented JsonPath parser, that enabled it the ability to query in the JSON file with more complex structure. Example: `DataManager.queryData($.firstObject.secondObject.thirdObject...)`
	- **Extent Report** (*TBC*)
- **Enhanced Element**
	- Implemented the Web Element interface
	- ![image](https://github.com/tuyenluong/WebSelenium/assets/76527250/033f7a42-d629-410c-9536-a0c55bf37f5e)
	- Provided lazy Init mechanism, only Init Web Element when the user call one of the actions.
	- ![image](https://github.com/tuyenluong/WebSelenium/assets/76527250/b797b346-ce2f-41dc-83eb-b2d2012cca8a)
	- Handled most exception when interact with the Web Element at Init . Example: `NoSuchElementException`, `StaleElementReferenceException`, `ElementNotInteractableException`, `TimeoutException`.
	- ![image](https://github.com/tuyenluong/WebSelenium/assets/76527250/a11a1608-b093-472e-9263-b024bbdde368)
 	
