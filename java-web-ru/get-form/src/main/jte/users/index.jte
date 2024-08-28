@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <div>
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getFirstName()}" />
            <input type="submit" value="Search" />
        </form>

        @if(page.getUsers().size() > 0)
            @for(var user : page.getUsers())
                <div>${user.getFirstName()} ${user.getLastName()}</div>
            @endfor
        @endif
    </div>
`
)