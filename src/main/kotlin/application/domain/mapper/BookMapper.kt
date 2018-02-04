package application.domain.mapper

import application.domain.Book
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

// multi datasource で hogehogeするにはもうちょっと工夫が必要かも
// https://qiita.com/KevinFQ/items/a8de808e7719315c376c
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