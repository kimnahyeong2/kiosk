import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int answer;
    static Order cart = new Order();
    static int num=1;

    public static void main(String[] args) {
        // 메인 메뉴 출력하기
        getMainMenu();
    }

    // 메인 메뉴판 ArrayList<Menu>에 추가
    private static void getMainMenu(){
        ArrayList<Menu> mainMenu = new ArrayList<>();
        mainMenu.add(new Menu("Gnocchi & Pasta  ", "시그니처 뇨끼와 파스타"));
        mainMenu.add(new Menu("Brunch           ", "아침에 즐기기 좋은 브런치 메뉴"));
        mainMenu.add(new Menu("Side Menu        ", "오늘의 수프와 추가 가능한 메뉴"));
        mainMenu.add(new Menu("Beverage         ", "커피, 티, 주스, 에이드 등 마실 것"));
        mainMenu.add(new Menu("Order            ", "장바구니를 확인 후 주문합니다."));
        mainMenu.add(new Menu("Cancel           ", "진행중인 주문을 취소합니다."));
        printMainMenu(mainMenu);
    }

    // 메인 메뉴판 출력하기
    private static void printMainMenu(ArrayList<Menu> mainMenu) {
        System.out.println("\nCozy Meal 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요!");
        System.out.println("\n[ Cozy Meal Menu ]");
        for (int i = 0; i < mainMenu.size() - 2; i++) {
            System.out.println((i + 1) + ". " + mainMenu.get(i).getName() + " | " + mainMenu.get(i).getExplain());
        }
        System.out.println("\n[ Order Menu ]");
        for (int i = mainMenu.size() - 2; i < mainMenu.size(); i++) {
            System.out.println((i + 1) + ". " + mainMenu.get(i).getName() + " | " + mainMenu.get(i).getExplain());
        }
        sc = new Scanner(System.in);
        answer = sc.nextInt();
        if (answer > 0 && answer <= mainMenu.size() - 2) { // 메뉴 선택했을 경우
            getProductMenu(answer, mainMenu);
        }
        else if(answer == mainMenu.size()-1){ // 주문하기 선택
            getOrder();
        }
        else{ // 주문취소 선택
            deleteOrder();
        }
    }

    // 각 카테고리의 상품
    private static void getProductMenu(int answer, ArrayList<Menu> mainMenu) {
        delay();
        System.out.println("\n아래 메뉴판을 보시고 상품을 골라 입력해주세요!");
        System.out.println("\n[ " + mainMenu.get(answer-1).getName().trim() + " Menu ]");

        ArrayList<Product> productMenu = new ArrayList<>();
        switch (answer - 1) {
            case 0 -> {
                productMenu.add(new Product("감바스 뇨끼      ", 2.3, "호밀식빵이 같이 제공됩니다."));
                productMenu.add(new Product("단호박 크림 뇨끼  ", 2.0, "단호박과 부드러운 크림이 만난 뇨끼"));
                productMenu.add(new Product("투움바 파스타     ", 1.7, "맵기는 크림 / 신라면 / 불닭 중 선택 가능합니다."));
                productMenu.add(new Product("할라피뇨 파스타   ", 1.7, "매콤한 파스타로 느끼하지 않은 파스타"));
                productMenu.add(new Product("바질페스토 파스타 ", 1.7, "요즘 유행인 바질페스토가 들어간 파스타"));
            }
            case 1 -> {
                productMenu.add(new Product("베이글 프렌치 토스트          ", 1.4, "쫄깃한 베이글로 만든 프렌치 토스트"));
                productMenu.add(new Product("코지밀 플레이트              ", 1.3, "계란, 당근라페와 함께 드시면 더욱 맛있습니다."));
                productMenu.add(new Product("리코타 바질 페스토 샌드위치    ", 1.3, "리코타 치즈와 바질의 조합"));
                productMenu.add(new Product("베이컨 토마토 디럭스 샌드위치  ", 1.3, "베이컨과 토미토의 조합은 실패없다!"));
                productMenu.add(new Product("에플 브리치즈 샌드위치        ", 1.2, "사과와 브리치즈의 조합"));
            }
            case 2 -> {
                productMenu.add(new Product("오늘의 스프     ", 0.7, "매일 바뀌는 오늘의 수프"));
                productMenu.add(new Product("감자튀김        ", 0.7, "짭조롬한 감자튀김"));
                productMenu.add(new Product("스크램블        ", 0.5, "몽실몽실한 스크램블"));
                productMenu.add(new Product("크로와상        ", 0.4, "버터향 가득한 크로와상"));
                productMenu.add(new Product("호밀식빵        ", 0.2, "감바스 뇨끼와 잘 어울리는 호밀식빵"));
                productMenu.add(new Product("딸기 잼 & 버터  ", 0.15, "딸기잼과 버터의 조합"));
            }
            case 3 -> {
                productMenu.add(new Product("아메리카노", 4.5, "현대인의 필수템"));
                productMenu.add(new Product("카페라떼", 5.0, "부드러운 라떼"));
                productMenu.add(new Product("바닐라 라떼", 5.5, "달콤한 바닐라 라떼"));
                productMenu.add(new Product("얼그레이 밀크티", 8.0, "ICE만 가능합니다"));
                productMenu.add(new Product("청포도 케일 주스", 6.5, "청포도와 케일이 만나 달콤하고 건강한 주스"));
                productMenu.add(new Product("초코라떼", 5.5, "달콤한 초콜릿으로 만든 초코라떼"));
                productMenu.add(new Product("콜라 / 제로콜라", 3.5, "콜라와 제로콜라 중 선택 가능합니다"));
                productMenu.add(new Product("사이다 / 제로사이다", 3.5, "사이다와 제로사이다 중 선택 가능합니다"));
                productMenu.add(new Product("자몽 에이드", 6.5, "상콤한 자몽으로 만든 에이드"));
                productMenu.add(new Product("망고 패션후르츠 에이드", 6.5, "달콤한 망고와 새콤한 패션후르츠의 조합"));
            }
        }
        printProductMenu(productMenu);
    }

    // 선택한 카테고리 상품 출력
    private static void printProductMenu(ArrayList<Product> productMenu) {
        for(int i=0; i<productMenu.size(); i++){
            System.out.println((i+1) + ". " + productMenu.get(i).getName() + " | W " + productMenu.get(i).getPrice() + " | " + productMenu.get(i).getExplain());
        }
        sc = new Scanner(System.in);
        answer = sc.nextInt();
        addToCart(productMenu.get(answer-1));
    }

    // 장바구니에 물건 담기
    private static void addToCart(Product product) {
        delay();
        System.out.println("\n\"" + product.getName() + " | W " + product.getPrice() + " | " + product.getExplain() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        answer = sc.nextInt();
        if(answer == 1){
            cart.add(product);
            System.out.println("\n"+product.getName().trim() + " 가 장바구니에 추가되었습니다.");
        }
        delay();
        getMainMenu();
    }

    // 장바구니 상품들 주문하기
    private static void getOrder() {
        ArrayList<Product> myCart = cart.getCart();
        double totalPrice = 0;

        if(myCart.size() == 0){
            System.out.println("장바구니에 담긴 상품이 존재하지 않습니다.");
            delay();
            getMainMenu();
        }

        System.out.println("아래와 같이 주문하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for(Product product : myCart){
            System.out.println(product.getName() + " | W " + product.getPrice() + " | " + product.getExplain());
            totalPrice += product.getPrice();
        }
        System.out.println("\n [ Total ]");
        System.out.println("W " + totalPrice);
        System.out.println("\n1. 주문      2. 메뉴판\n");
        answer = sc.nextInt();
        if(answer == 1){
            cart.clear();
            System.out.println("주문이 완료되었습니다!\n");
            System.out.println("대기번호는 [ " + num + " ] 번 입니다.");
            num++;
            System.out.println("3초후 메뉴판으로 돌아갑니다.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        getMainMenu();
    }

    // 주문취소 (장바구니 삭제)
    private static void deleteOrder() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        answer = sc.nextInt();
        if(answer == 1){
            cart.clear();
            System.out.println("진행하던 주문이 취소되었습니다.");
        }
        getMainMenu();
    }

    // 시간 늦추기
    public static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}