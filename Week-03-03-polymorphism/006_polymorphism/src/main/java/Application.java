public class Application {
    public static void main(String[] args) {
        Windows aWindowsApp = new Windows();
        Windows intellijIdea = new IntellijIdea();
        Windows chrome = new Chrome();
        Windows wechat = new Wechat();

        System.out.println("a windows app:");
        aWindowsApp.eventOnClickF5();
        System.out.println("=================");

        System.out.println("IntelliJ Idea:");
        intellijIdea.eventOnClickF5();
        System.out.println("=================");

        System.out.println("chrome:");
        chrome.eventOnClickF5();
        System.out.println("=================");

        System.out.println("wechat:");
        wechat.eventOnClickF5();
        System.out.println("=================");
    }
}
