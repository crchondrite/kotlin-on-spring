package application.domain.mapper

import application.domain.Book
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface BookMapper {
    @Select("""
        SELECT
            isbn, title, price
        FROM
            books
    """)
    fun findAll(): List<Book>

}