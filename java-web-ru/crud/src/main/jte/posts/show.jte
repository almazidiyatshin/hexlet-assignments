@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <a href="/posts">Вернуться к списку постов</a>

    <h1>${page.getPost().getName()}</h1>
    <div>${page.getPost().getBody()}</div>
`
)
