trait Monad[F[_]] {

    def pure[A](a: A): F[A]

    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

    def map[A, B](a: F[A])(f: A => B): F[B] = flatMap(a)(f.andThen(pure))

    def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] = flatMap(fa)(a => flatMap(fb)(b => pure(f(a, b))))

    def sequence[A](fas: List[F[A]]): F[List[A]] = map(fas.foldLeft(pure(List.empty[A]))((acc, v) => map2(acc, v)((acc, v) => v :: acc)))(_.reverse)

    def compose[A, B, C](f: A => F[B])(g: B => F[C]): A => F[C] = f.andThen(flatMap(_)(g))
}

trait Functor[F[_]] {
    def map[A, B](a: F[A])(f: A => B): F[B]
}

object Functor {
    implicit def functorFromMonad[F[_]](M: Monad[F]): Functor[F] = new Functor[F] {
        def map[A, B](a: F[A])(f: A => B): F[B] = M.map(a)(f)
    }
}