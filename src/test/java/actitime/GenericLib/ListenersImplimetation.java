package actitime.GenericLib;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ListenersImplimetation implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result)
    {
        String tcname=result.getName();
        TakesScreenshot ts=(TakesScreenshot)BaseClass.listenerDriver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File("./FailedTC's/"+tcname+".png");
        try {
            FileUtils.copyFile(src, trg);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
