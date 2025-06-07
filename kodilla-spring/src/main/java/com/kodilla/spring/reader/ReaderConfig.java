package com.kodilla.spring.reader;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ReaderConfig {

    /* NOT RECOMMENDED APPROACH
    @Autowired
    @Qualifier("book1")
    Book book;

    @Bean
    public Reader getReader() {
        return new Reader(book);
    }
    */

    @Bean
    public Reader getReader(@Qualifier("book1") Book book) {
        return new Reader(book);
    }

    /* CHOOSING BEAN TO READ BASED ON CONDITION
    @Bean
    public Reader getReader(ConfigurableApplicationContext context) {
        if (context.containsBean("book2")) {
            return new Reader(context.getBean("book2", Book.class));
        } else {
            return new Reader(context.getBean("book1", Book.class));
        }
    }
     */

    @Bean(name = "book1")
    /* WE SHOULD AVOID @Scope("prototype") because beans created in this way are not cleaned if not mentioned explicitly */
    @Scope("prototype")
    public Book getBookOne() {
        return new Book("The book number one");
    }

    @Bean(name = "book2")
    /* WE SHOULD AVOID @Scope("prototype") because beans created in this way are not cleaned if not mentioned explicitly */
    @Scope("prototype")
    @Conditional(IfDayIsOddCondition.class)
    public Book getBookTwo() {
        return new Book("The book number two");
    }
}
