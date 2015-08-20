.class final Landroid/support/v4/speech/tts/TextToSpeechICSMR1$2;
.super Ljava/lang/Object;
.source "TextToSpeechICSMR1.java"

# interfaces
.implements Landroid/speech/tts/TextToSpeech$OnUtteranceCompletedListener;


# instance fields
.field final synthetic a:Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;


# virtual methods
.method public onUtteranceCompleted(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Landroid/support/v4/speech/tts/TextToSpeechICSMR1$2;->a:Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;

    invoke-interface {v0, p1}, Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;->c(Ljava/lang/String;)V

    .line 69
    iget-object v0, p0, Landroid/support/v4/speech/tts/TextToSpeechICSMR1$2;->a:Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;

    invoke-interface {v0, p1}, Landroid/support/v4/speech/tts/TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;->a(Ljava/lang/String;)V

    .line 70
    return-void
.end method
