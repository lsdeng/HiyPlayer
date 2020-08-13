#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_hiy_hiyplayer_page_SplashActivity_stringFromJNI(JNIEnv *env, jobject thiz, jstring origin) {

//    char cStr[100] = new char[100];
//    util_jstring_to_char(env, origin, cStr);
//    char *targetStr2 = "welcome C++ ";
//    strcat(cStr, targetStr2); // 关注内存大小
//    return env->NewStringUTF(targetStr);


// 第二种实现方式
//    char *cStr = (char *) env->GetStringUTFChars(origin, JNI_FALSE);
//    char *nStr = "欢迎来到JNI的世界1111";
//    strcat(cStr, nStr);
    return env->NewStringUTF("cStr");
}



extern "C"
JNIEXPORT jint JNICALL
Java_com_hiy_hiyplayer_page_SplashActivity_plus(JNIEnv *env, jobject thiz, jint a, jint b) {
    jint sum = a + b;
    return sum;
}


void util_jstring_to_char(JNIEnv *env, jstring jstr, char *result) {
    if (env == NULL || jstr == NULL) {
        return;
    }
    jclass clsstring = env->FindClass("java/lang/String");
    jstring strencode = env->NewStringUTF("utf-8");
    jmethodID mid = env->GetMethodID(clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray) env->CallObjectMethod(jstr, mid, strencode);
    jsize alen = env->GetArrayLength(barr);
    jbyte *ba = env->GetByteArrayElements(barr, JNI_FALSE);
    if (alen > 0) {
        memcpy(result, ba, alen);
        result[alen] = 0;
    }
    env->ReleaseByteArrayElements(barr, ba, 0);
}
