abstract class BaseDayTest {
    protected val inputPath: String
        get() {
            val folder = this.javaClass.simpleName.lowercase().substringBefore("test")
            return "./src/test/resources/$folder/input.txt"
        }

    abstract fun `test part 1`()

    abstract fun `test part 2`()
}