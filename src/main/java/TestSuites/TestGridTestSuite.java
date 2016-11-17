package TestSuites;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import TestCategories.TestGridTest;

@RunWith(Categories.class)
@IncludeCategory(TestGridTest.class)
@SuiteClasses({})
public class TestGridTestSuite {

}
