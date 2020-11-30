# 1. Functions and Variables

## 1. Hello World!

```kotlin
fun helloWorld() {
    println("Hello World!")
}
```

kotlin에서는 다음과 같은 규칙을 바탕으로 프로그래밍을 합니다.

1. 함수를 선언할 때는 `fun` 키워드를 사용합니다.
2. 파라미터 이름 뒤에 파라미터의 타입을 씁니다.
3. 함수를 최상위 수준에서 정의할 수 있습니다. 자바와 달리 클래스 안에 함수를 넣을 필요가 없습니다.
4. 배열도 일반적인 클래스로 처리합니다. 자바와 달리 배열 처리를 위한 문법이 따로 존재하지 않습니다.
5. `System.out.println` 대신에 `println`을 사용해 출력합니다. kotlin은 자바 라이브러리 함수를 간결하게 사용하는 wrapper를 제공합니다.
6. 라인의 끝에 `;`을 붙이지 않아도 됩니다.

## 2. Function

```kotlin
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
```

kotlin의 함수는 `fun` 키워드 다음에 함수 이름이 옵니다. 그리고 소괄호 안에 파라미터 목록이 적힙니다. 그 뒤에는 `:`을 붙이고 함수의 반환값의 타입을 적어줍니다. 그 결과는 위의 예시와 같습니다.

```plain text
statement와 expression의 구분

kotlin에서 if는 식(expression)이지 문(statement)이 아닙니다. 식은 값을 만들고 다른 식의 하위 요소로 계산에 참여할 수 있지만 문은 자신을 둘러싸고 있는 가장 안쪽 블록의 최상위 요소로 존재하며 아무런 값을 만들어내지 않습니다.

자바에서느 모든 제어 구조가 문인 반면 kotlin에서는 loop를 제외한 대부분의 제어 구조가 식입니다. 따라서 제어 구조를 다른 식으로 엮어낼 수 있으면 여러 일반적인 패턴을 아주 간결하게 표현할 수 있습니다.

반면 대입문은 자바에서는 식이었으나 kotlin에서는 문이 되었습니다. 그로 인해 자바와 달리 대입식과 비교식을 잘못 바꿔 써서 버그가 생기는 경우가 없습니다.
```

예시 함수를 더 간결하게 줄일 수 있습니다. 함수 본문이 식 하나로 이루어진 경우가 이에 해당합니다.

```kotlin
fun max(a: Int, b: Int): Int = if (a > b) a else b
```

만약 이를 더 간결하게 줄인다면 함수의 반환 타입을 없앨 수 있습니다.

```kotlin
fun max(a: Int, b: Int) = if (a > b) a else b
```

이는 kotlin이 정적 타입 언어이지만 kotlin compiler가 함수 본문 식을 분석해 그 결과 타입을 함수 반환 타입으로 정해줍니다. 이를 **타입 추론**이라고 합니다. 다만 위와 같이 생략하기 위해서는 식이 본문인 함수의 반환 타입만 생략 가능함을 인지해야 합니다.

## 3. Variable

자바에서 변수를 선언할 때 타입이 맨 앞에 오지만 kotlin은 타입 지정을 생략하는 경우가 흔합니다. 이는 타입으로 변수 선언을 시작하면 타입을 생략한 경우 식과 변수 선언을 구별할 수 없기 때문입니다. 따라서 kotlin은 키워드로 변수 선언을 시작하는 대신에 이름 뒤에 타입을 명시하거나 생략해 사용합니다.

```kotlin
val answer = 42
val answer: Int = 42
```

만일 타입이 지정되지 않았다면 컴파일러가 식을 분석해서 변수 타입을 지정합니다. 만약 초기화 식을 사용하지 않고 변수를 선언하려면 변수 타입을 반드시 명시해야 합니다.

```kotlin
val answer: Int

answer = 42
```

kotlin도 변경 가능한 변수와 변경 불가능한 변수가 있습니다.

1. `val`: 변경 불가능한 참조를 저장하는 변수입니다. 선언된 변수는 재대입이 불가능합니다. 자바에서는 `final`에 대응합니다.
2. `var`: 변경 가능한 참조입니다. 이 변수의 값은 언제든지 바뀔 수 있으며 자바의 일반 변수에 해당합니다.

일반적으로 모든 변수를 `val`로 선언하고 필요한 경우에만 `var`을 사용하는 것을 추천합니다. `val`은 블록을 실행할 때 정확히 한 번만 초기화돼야 합니다. 하지만 어떤 블록이 실행될 때 오직 한 초기화 문장만 실행됨을 컴파일러가 알 수 있다면 조건에 따라 `val`을 여러 값으로 초기화할 수 있습니다.

```kotlin
fun variables(isTrue: Boolean): String {
    val message: String

    if (isTrue == true) {
        message = "Success"
    } else {
        message = "Failed"
    }

    return message
}
```

단, `val` 참조 자체는 불변일지라도 그 참조가 가리키는 객체의 내부 값은 변경될 수 있습니다. 반면에 `var` 키워드는 변수의 값을 변경할 수 있지만 변수 타입은 고정되어 바꿀 수 없습니다.

```kotlin
val languages = arrayListOf("Java")
languages.add("Kotlin")

var answer = 42
answer = "no" // Error: type mismatch
```

만약 어떤 타입의 변수에 다른 타입의 값을 저장하고 싶다면 변환 함수를 써서 값을 변수의 타입으로 변환하거나 값을 변수에 대입할 수 있는 타입으로 강제 형 변환해야 합니다.

## 4. String template

```kotlin
fun greeting(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello $name!")
}
```

위 예제는 **문자열 템플릿** 기능에 대한 예제입니다. kotlin에서 변수를 문자열 안에서 사용하기 위해서 문자열에 변수를 넣되 변수 앞에 `$`를 추가해야 합니다. 이는 자바의 문자열 접합 연산과 동일한 기능이지만 좀 더 간결하며 자바 문자열 접합 연산을 사용한 식과 마찬가지로 효율적입니다. 물론 컴파일러가 각 식을 정적으로 검사하기 때문에 존재하지 않는 변수를 문자열 템플릿 안에서 사용하면 오류가 발생합니다.

만약 복잡한 식을 사용해야 한다면 `{}`를 사용해서 문자열 템플릿 안에 넣을 수 있습니다.

```plain text
한글을 문자열 템플릿에서 사용할 경우 주의할 점

kotlin은 자바와 마찬가지로 한글을 식별자에 사용할 수 있어 변수 이름에 한글이 들어갈 수 있습니다. 하지만 문자열 템플릿을 사용할 때 $ 뒤에 변수를 입력하고 바로 문자를 사용하면 이들을 하나로 인식해 컴파일러 오류가 발생합니다. 이 때 ${variables}와 같이 변수를 {}로 감싸면 오류를 해결할 수 있습니다.
```

또한 {}로 둘러싼 식에서 ""를 사용할 수 있습니다.

```kotlin
fun call(args: Array<String>) {
    println("Hello ${if (args.size > 0) args[0] else "someone"}!")
}
```

# 2. Class and Property

## 1. Property

클래스의 목적은 데이터를 캡슐화하고 캡슐화한 데이터를 다루는 코드를 한 주체 아래 가두는 것입니다.

자바에서는 데이터를 필드에 저장하고 멤버 필드의 가시성은 보통 비공개로 합니다. 이 때 클래스는 자신을 사용하는 클라이언트가 데이터를 접근하는 통로로 쓸 수 있는 **접근자 메소드**를 제공합니다. 일반적으로 필드를 읽기 위해서는 getter를, 필드를 변경하는 경우 setter를 추가로 제공합니다. 특히, setter의 경우 자신이 받은 값을 검증하거나 필드 변경을 다른 곳에 통지하는 로직을 추가하기도 합니다.

자바에서는 필드와 접근자를 한데 묶어 **프로퍼티**라고 부릅니다. kotlin은 프로퍼티를 언어 기본 기능으로 제공하며 kotlin의 프로퍼티는 자바의 필드와 접근자 메소드를 완전히 대신합니다. 이 때 `val`로 선언한 프로퍼티는 읽기 전용이며, `var`로 선언한 프로퍼티는 변경이 가능합니다.

kotlin에서 프로퍼티를 선언하는 방식은 프로퍼티와 관련 있는 접근자를 선언하는 것입니다. 그를 위해 kotlin은 값을 저장하기 위한 비공개 필드와 그 필드에 값을 저장하기 위한 setter, 값을 읽기 위한 getter로 이루어진 간단한 접근자 구현을 제공합니다.

두 언어의 getter와 setter은 거의 동일한 방식으로 구현되어 있습니다. 다만 예외가 있는데 이른이 `is`로 시작하는 프로퍼티의 getter에는 `get`이 붙지 않고 원래 이름을 그대로 사용하며 setter는 `is` 대신에 `set`으로 바꾼 이름을 사용합니다.

```java
public class Person {
    private final String name;
    private Boolean isMarried;

    public Person(String name, Boolean isMarried) {
        this.name = name;
        this.isMarried = isMarried;
    }

    public String getName() {
        return name;
    }

    public Boolean isMarried() {
        return isMarried;
    }

    public Boolean setMarried(Boolenan isMarried) {
        this.isMarried = isMarried;
    }
}

public static void main() {
    Person person = new Person("Java", true);

    System.out.println(person.getName());
    System.out.println(person.isMarried();

    person.setMarried(false);
}
```

```kotlin
class Person (
    val name: String,
    var isMarried: Boolean
)

fun main() {
    // new keyword를 사용하지 않고 생성자를 호출합니다.
    val person = Person("Kotlin", true)

    // 프로퍼티 이름을 직접 사용해도 kotlin이 자동으로 getter를 호출합니다.
    println(person.name)
    println(person.isMarried)

    // 프로퍼티의 setter도 이름을 직접 사용할 수 있습니다.
    person.isMarried = false
}
```

대부분의 프로퍼티에는 그 프로퍼티의 값을 저장하기 위한 필드가 있는데 이를 **backing field(뒷받침하는 필드)**라고 부릅니다. 하지만 원한다면 프로퍼티 값을 그 때 그 때 계산할 수도 있는데 이는 커스텀 접근자를 작성하면 가능합니다.

## 2. Custom Getter

직사각형 클래스를 정의하고 자신이 정사각형인지 알려주는 기능을 만드는 예제를 통해 커스텀 접근자를 생성해 보겠습니다.

```kotlin
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}
```

위와 같이 `isSquare` 프로퍼티는 자체 값을 저장하는 필드가 없이 자체 구현만을 제공합니다. 이 경우 클라이언트가 프로퍼티에 접근할 때 마다 getter가 프로퍼티 값을 매번 다시 계산합니다.

파타미터가 없는 함수를 정의하는 방식과 커스텀 접근자를 정의하는 방식 중 어느 쪽이 더 나은가 궁금하다면 그 답은 비슷하다고 할 수 있습니다. 차이가 나는 부분은 가동성뿐이며 일반적으로 클래스의 특성을 정의하고 싶다면 프로퍼티로 그 특성을 정의해야 합니다.

## 3. Directory and Package

자바가 모든 클래스를 패키지 단위로 관리하는 것과 같이 kotlin에도 이와 비슷한 개념의 패키지가 있습니다. 모든 `.kt` 파일의 맨 앞에 `package` 문을 넣을 수 있는데 이 경우 그 파일 안에 있는 모든 선언은 해당 패키지에 들어갑니다. 같은 패키지에 속해 있다면 다른 파일에서 정의한 선언일지라도 직접 사용할 수 있습니다. 반면 다른 패키지에 정의한 선언을 사용하려면 import를 통해 선언을 불러와야 합니다. 자바와 동일하게 import는 파일의 맨 앞에 와야 하며 `import` 키워드를 사용합니다.

```kotlin
// 패키지 이름을 선언합니다.
package geometry.shapes

// 표준 자바 라이브러리 클래스를 불러옵니다.
import java.util.Random

class RealRectangle(val height: Int, val width: Int) {
    val isRealSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): RealRectangle {
    val random = Random()
    return RealRectangle(random.nextInt(), random.nextInt())
}
```

```kotlin
package geometry.example

// 이름으로 함수를 불러옵니다.
import geometry.shapes.createRandomRectangle

fun main() {
    println(createRandomRectangle().isRealSquare)
}

```

패키지 이름 뒤에 `.*`를 추가하면 패키지 안의 모든 선언을 불러올 수 있습니다. 하지만 이 경우 패키지 안에 있는 모든 클래스와 최상위 함수, 프로퍼티까지 모두 불러오므로 주의가 필요합니다.

자바에서는 패키지의 구조가 일치하는 디렉터리 계층 구조를 만들고 클래스의 소스코드를 그 클래스가 속한 패키지와 같은 디렉터리에 위치시켜야 합니다. 하지만 kotlin은 여러 클래스를 한 파일에 넣을 수 있고, 파일 이름도 마음대로 정할 수 있습니다. 하지만 대부분의 경우 자바와 같이 패키지별로 디렉터리를 구성하는 편이 좋습니다. 이는 자바 레거시 프로젝트에서 자바 클래스를 kotlin 클래스로 마이그레이션할 때 문제가 발생할 수 있기 때문입니다.
