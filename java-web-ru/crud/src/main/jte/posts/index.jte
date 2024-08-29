@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <h1>Посты</h1>

   <ul>
        @for(var post : page.getPosts())
            <li>
                <a href="/posts/${post.getId()}">${post.getName()}</a>
            </li>
        @endfor
    </ul>

    <a href="/posts?page=${page.getPageNumber() - 1}">Назад</a>
    <a href="/posts?page=${page.getPageNumber() + 1}">Вперед</a>
`
)
