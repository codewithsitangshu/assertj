# AssertJ Assertions

![Alt Text](assertj-header.gif)

# AssertJ Custom Assertions For Test Automation

Automated testing is a cornerstone of modern software development, ensuring reliability and efficiency in the development lifecycle. AssertJ, a fluent assertion library for Java, empowers developers to write expressive and readable tests. With its intuitive API and rich set of features, AssertJ simplifies the process of writing and maintaining test cases. From basic assertions to complex object comparisons, AssertJ provides a robust toolkit for verifying software behavior. In this blog, we'll explore how AssertJ enhances automation testing, enabling developers to create comprehensive test suites with ease. Let's dive into the world of AssertJ and harness its capabilities to elevate our testing practices.

# Maven

To include AssertJ in your Java project, include below maven dependency in your pom file. Check the maven repo [here](https://mvnrepository.com/artifact/org.assertj/assertj-core) for the latest versions

``` xml
<dependency>
    <groupId>org.assertj</groupId>
    <artifactId>assertj-core</artifactId>
    <version>3.25.3</version>
    <scope>test</scope>
</dependency>
```

Once you have included in your pom file, do the below static import in your test classes.

``` java
import static org.assertj.core.api.Assertions.assertThat;
```

# Basic AssertJ Examples:


Let's start with few simple examples.

# String Verification with AssertJ

When dealing with an array of Strings, ensuring their properties can be a complex task. AssertJ simplifies this process with its fluent assertion API, making it remarkably readable and easing the burden on developers.

- **String Length**: Verify that the size of the string is greater than 5 characters.
- **Substring Check**: Ensure that the string contains "i" as a substring.
- **Single Instance**: Confirm that the string contains only one instance of the letter "i".
- **Starts with**: Check if the string starts with the letter "a".
- **Exclusion**: Verify that the string does not contain "rest" as a substring.
- **Whitespace Absence**: Ensure that the string does not contain any whitespace characters. (any many more...)

AssertJ empowers developers to express these conditions succinctly, enhancing the readability and maintainability of code, ultimately simplifying the testing process.

``` Java
public class StringTest {

    @Test(dataProvider = "data")
    public void test(String actual) {
        assertThat(actual)
                .hasSizeGreaterThan(5)
                .contains("i")
                .containsOnlyOnce("i")
                .startsWith("a")
                .doesNotContain("rest")
                .doesNotContainAnyWhitespaces()
                .hasSize(9);
    }

    @DataProvider
    private String[] data () {
        return new String[] {
                "algorithm",
                "automation",
                "assertion"
        };
    }

}
```