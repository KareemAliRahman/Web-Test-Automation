package com.sqs.internalproject.tests.testGroups;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(AndroidTests.class)
@SuiteClasses({})
public class AndroidTestSuite {
    
}
