package application.service

import application.domain.mapper.BookMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService @Autowired constructor(
    val bookMapper: BookMapper
) {
    fun findAll() = bookMapper.findAll()
}
