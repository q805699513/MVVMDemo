/**
 * @author LongShaoHua
 * @date 2021/6/15
 */
object Versions{
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 19
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val kotlinVersion = "1.5.10"

    const val retrofitVersion = "2.9.0"
    const val okhttpVersion = "4.9.0"

    const val junit = "1.1.2"
    const val espressoCore = "3.3.0"
    const val coreKtx = "1.3.2"
    const val appcompat = "1.2.0"
    const val constraintLayout = "2.0.4"
    const val lifecycleViewModelKtx = "2.3.1"
    const val recyclerview = "1.1.0"
    const val brvah = "3.0.4"

}

object Libs{
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtx}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val brvah = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.brvah}"


}
