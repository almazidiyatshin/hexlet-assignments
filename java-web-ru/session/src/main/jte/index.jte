@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(content = @`
    <main>
        @if(page.getName() != null)
            <h1>Привет, ${String.valueOf(page.getName())}!</h1>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" value="Выйти"/>
            </form>
        @endif

        @if(page.getName() == null)
            <form action="${NamedRoutes.buildSessionPath()}" method="get">
                <input type="submit" value="Войти"/>
            </form>
        @endif
    </main>
`)