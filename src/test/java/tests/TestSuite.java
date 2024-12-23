package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        SignInTest.class,
        SignUpTest.class,
        GuestUserNavBarTest.class,
        RegisteredUserNavBarTest.class,
        TitlePageTest.class,
        LanguageOptionsTest.class,
        WatchlistTest.class,
        RecentlyViewedTest.class,
        SearchTest.class,
        SearchFilterTest.class,
        RateTest.class,
        ResponsivenessTest.class,
        ResponseTimeTest.class,
        HTTPSTest.class,
        XSSTest.class,
        SQLInjectionTest.class
})
public class TestSuite {
}


