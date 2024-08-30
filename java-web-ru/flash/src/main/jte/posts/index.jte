@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
page = page,
content = @`
    <ul>
        @for(var post : page.getPosts())
            <li>
                <div>${post.getName()}</div>
                <div>${post.getBody()}</div>
            </li>
        @endfor
    </ul>
`
)