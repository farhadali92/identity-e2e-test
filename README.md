# Identity E2E Tests

### Pre-requisites

* Create a folder in C drive named RandomFiles
* Add random files including excel files containing vehicle registration data
* Make sure that vehicle registration excel file conforms to following format:

| RegNo | Make | Colour |
| ----- | ---- | ------ |
| EU52 JCO | FORD | GREY |

Please have a look at files in example-data folder.

### How to run the test

To run tests which loads files from c:\\RandomFiles

```
mvn verify
```

### How to change files folder

In FileReaderService, change the value of constant DEFAULT_DIRECTORY according to requirement

## Assumptions

* All excel files contains vehicle registration details in required format

## Future Development

* Implement data format validation upon reading the file
* Implement CSV reader to enable reading vehicle details from CSV file
* Implement XLS reader to enable reading vehicle details from Pre 2003 excel files
