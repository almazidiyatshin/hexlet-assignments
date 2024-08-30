@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
    content = @`
    <div>
        @if(page.getError() != null)
            <div>${page.getError()}</div>
        @endif

        <form action="${NamedRoutes.loginPath()}" method="post">
            <input type="text" placeholder="Name" name="name" value="${page.getName()}" />
            <input type="password" placeholder="Password" name="password" />
            <input type="submit" value="Войти" />
        </form>
    </div>
    `
)