package com.ILab.utilities;

import com.ILab.testCases.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends BaseClass {



    String timeStamp = new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date());
    String reportName="Test-Report-" +timeStamp+".html";



}
