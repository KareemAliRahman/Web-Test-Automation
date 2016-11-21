package practice.TestSuites;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import practice.TestCategories.ChromeTest;

@RunWith(Categories.class)
@IncludeCategory(ChromeTest.class)
@SuiteClasses({})
public class ChromeTestSuite{

}
